#! /bin/sh
sys_led_trigger="/sys/devices/platform/gta02-led.0/leds/gta02-aux:red/trigger"
if test -e $sys_led_trigger ;then
        echo bat-charging > $sys_led_trigger
fi

