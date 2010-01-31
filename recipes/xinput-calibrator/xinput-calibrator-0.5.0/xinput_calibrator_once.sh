#!/bin/sh
if [ -e /etc/pointercal.xinput ] ; then
  echo Using calibration data stored in /etc/pointercal.xinput
  . /etc/pointercal.xinput
else
  CAL=`/usr/bin/xinput_calibrator | tee /etc/pointercal.xinput.log | grep xinput| sed 's/^ //g; s/$/;/g'`
  if [ ! -z "$CAL" ] ; then
    echo $CAL > /etc/pointercal.xinput
    echo Calibration data stored in /etc/pointercal.xinput
  fi
fi
