#! /bin/bash

PROC=`ps | grep chronyd | grep -v grep`;

if [ -n "$PROC" ]; then

   RESULT=`chronyc << ___EOF
   password opensesame
   online
___EOF`

   RESULT2=`echo $RESULT | grep OK`
   if [ -n "$RESULT2" ]; then
      echo 1
   else
      echo 0;
   fi
else
    echo -1;
fi