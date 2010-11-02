#!/bin/sh 
# The user can request that we initialize concierge as
# part of startup by holding down hotkeys 1 and 3 during
# boot.
# The user can request that we remove all existing BUG
# applications and also initialize concierge as part of
# startup by holding down hotkeys 2 and 4 during boot.
# The bugnav driver has a proc file that reports the
# current state of the BUGbase buttons, so we use that
# to figure out whether we need to do anything special


#Not sure how much of this is actually accurate for 2.0 since the pMEA=>openjdk, concierge=>felix, new button interface. commenting out for now
#INIT_BUTTON_CHECK=$(egrep "M1 1|M2 0|M3 1|M4 0" /proc/bugnav|wc -l)
#RESET_BUTTON_CHECK=$(egrep "M1 0|M2 1|M3 0|M4 1" /proc/bugnav|wc -l)
#RUN_DIR=/usr/share/java
#INIT_ARG=-Dosgi.init=true
#
#CVM_DIR=/usr/lib/jvm/phoneme-advanced-personal-debug
#CVM_PATH=/usr/bin/java
#CVM_PARAMS=
#
#if [ -n "$WANT_DEBUG" ]; then
#  echo 'Running debug CVM'
#  # example to stop before running any code and wait for debugger client to connect to us on port 5000
#  CVM_PARAMS='-Xdebug  -Xrunjdwp:transport=dt_socket,server=y,address=5000 '
#elif [ -n "$WANT_PROFILE" ]; then
#  # this is an example profile run; change it to '-agentlib:jvmtihprof=help' to see all the options
#  CVM_PARAMS="-agentlib:jvmtihprof=heap=all,cpu=samples,file=/tmp/profile.txt -Xbootclasspath/a:$CVM_DIR/lib/java_crw_demo.jar"
#fi
#
#if [ $INIT_BUTTON_CHECK = 4 ]; then
#  echo 'init request by user'
#  INIT=$INIT_ARG
#elif [ $RESET_BUTTON_CHECK = 4 ]; then
#  echo 'reset requested by user'
#  INIT=$INIT_ARG
#  echo 'removing existing apps'
#  /bin/rm -f $RUN_DIR/apps/*.jar
#else
#  echo 'normal startup'
#  INIT=
#fi
export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/usr/lib/jni

export DISPLAY=:0.0
/usr/bin/java -Xmx64M -Dfelix.config.properties=file:///usr/share/java/conf/config.properties -Dfreetype.font=/usr/share/fonts/ttf/LiberationSans-Regular.ttf -Djava.library.path=/usr/lib/jni -jar /usr/share/java/felix.jar
#$CVM_PATH $CVM_PARAMS -Xmx64M -cp concierge.jar -Dfreetype.font=/usr/share/fonts/ttf/LiberationSans-Regular.ttf -Djava.library.path=/usr/lib/jni -Dxargs=$RUN_DIR/init.xargs $INIT ch.ethz.iks.concierge.framework.Framework 
