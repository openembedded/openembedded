#!/bin/sh
if [ -e /sys/class/net/eth0 ]; then
    echo phy1assoc > /sys/class/leds/omap3bug\:green\:wifi/trigger
else
    echo phy0assoc > /sys/class/leds/omap3bug\:green\:wifi/trigger
fi
echo none > /sys/class/leds/omap3bug\:red\:wifi/trigger
