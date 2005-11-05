#!/bin/sh
#

# The location of the ppp daemon itself (shouldn't need to be changed)
PPPD=/usr/sbin/pppd

# The Ethernet interface the DSL modem is connected to. If you change this, 
# you also need to edit the file /etc/ppp/peers/dsl-provider.
INTERFACE=eth0

# Bring the interface up
/sbin/ifconfig $INTERFACE up

$PPPD call dsl-provider
