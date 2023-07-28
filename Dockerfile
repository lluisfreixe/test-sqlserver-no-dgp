FROM eclipse-temurin:8-jdk-focal
RUN echo "==================================================================="
RUN echo " Entorn NO DGP "
RUN echo " URL de connexio a SQLServer "
RUN echo " spring.datasource.url = jdbc:sqlserver://10.46.141.54;databaseName=CUSTODIAGNOSTIC"
RUN echo " NOVA URL spring.datasource.url = jdbc:sqlserver://10.47.253.163:1433;databaseName=ADMWCMDBLIPRE1\CMDBNUCLI"
RUN echo "==================================================================="
ENV TZ=Europe/Madrid
ADD target/test-sqlserver-no-dgp-1.0.jar test-sqlserver-no-dgp-1.0.jar
ENTRYPOINT ["java", "-jar", "test-sqlserver-no-dgp-1.0.jar"]

