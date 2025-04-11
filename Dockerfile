	# -------- STAGE 1: Build --------
	FROM eclipse-temurin:17-jdk AS builder
	WORKDIR /app
	COPY . .
	RUN ./mvnw clean package -DskipTests

	# -------- STAGE 2: Runtime --------
	FROM gcr.io/distroless/java17
	WORKDIR /app
	COPY --from=builder /app/target/rest-webservice-0.0.1-SNAPSHOT.jar app.jar
	ENTRYPOINT ["java", "-jar", "/app/app.jar"]