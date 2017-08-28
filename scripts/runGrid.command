#!/bin/bash

arch -i386 /usr/bin/osascript -e 'tell app "Terminal" to do script "java -jar ~/lib/selenium-server-standalone-2.25.0.jar -role hub" '
arch -i386 /usr/bin/osascript -e 'tell app "Terminal" to do script "java -jar ~/lib/selenium-server-standalone-2.25.0.jar -role node -hub http://localhost:4444/grid/register -browser browserName=firefox,version=13,maxInstances=5,platform=MAC -browser browserName=chrome,version=21,maxInstances=5,platform=MAC" '
	 
exit
	 
arch -i386 /usr/bin/osascript <<END
tell application "iTerm"
 tell the first terminal
  launch session "Default Session"
  tell the last session
    to do script "java -jar ~/lib/selenium-server-standalone-2.25.0.jar -role hub"
  end tell
 end tell
end tell
END	 