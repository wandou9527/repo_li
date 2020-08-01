echo =================================
psid=0
javaps=`jps -l | grep mouse0823c`
 if [ -n "$javaps" ]; then
    psid=`echo $javaps | awk '{print $1}'`
 else
    psid=0
 fi
 if [ $psid -ne 0 ]; then
    echo -n "Stopping mouse0823clala ...(pid=$psid) "
    `kill -9 $psid`
    if [ $? -eq 0 ]; then
       echo "[OK]"
    else
       echo "[Failed]"
    fi
 else
    echo "================================"
    echo "info: is not running"
    echo "================================"
 fi
echo '准备自动启动「mouse」服务'
cd /java/git_site/repo_li/mouse0823c
echo 'git pull ...'
git pull
echo 'mvn clean package ...'
mvn clean package -Dmaven.test.skip=true
echo '进入 target 目录'
cd /java/git_site/repo_li/mouse0823c/target
echo 'run java -jar 。。。'
nohup java -Xmx64m -Xms64m -XX:ParallelGCThreads=2 -Djava.compiler=NONE -jar mouse0823c-1.1.8.jar --spring.profiles.active=dev &
sleep 5
tail -f nohup.out
sleep 30
exit 0



