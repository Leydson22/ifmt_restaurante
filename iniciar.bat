@echo off
echo ========================================
echo   Iniciando o Projeto Restaurante
echo ========================================

if exist .env (
    echo Carregando variaveis do arquivo .env...
    for /f "tokens=*" %%a in (.env) do (
        set %%a
    )
) else (
    echo AVISO: Arquivo .env nao encontrado. Usando valores padrao.
)

echo.
echo Compilando e executando a aplicacao Spring Boot...
call mvnw.cmd spring-boot:run

pause
