#!/bin/sh
echo "Setting up bluetooth hci_uart" > /dev/console
/usr/sbin/bccmd -t bcsp -d /dev/ttyS1 psload -r -s psram /etc/udev/scripts/working.psr
/usr/sbin/bccmd -t bcsp -d /dev/ttyS1 psload -r -s psram /etc/udev/scripts/working.psr
hciattach /dev/ttyS1 bcsp 115200
hciconfig hci0 reset
echo "Bluetooth setup completed." > /dev/console
