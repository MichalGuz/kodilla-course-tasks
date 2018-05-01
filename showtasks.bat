call runcrud.bat
if "%ERRORLEVEL%" == "0" goto browser
echo.
echo RUNCRUD.BAT has errors - breaking work
goto fail

:browser
call start chrome "http://localhost:8080/crud/v1/task/getTasks"
if "%ERRORLEVEL%" == "0" goto end
echo.
echo BROWSER ERROR choosen browser is unreached or check your internet connection
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished
