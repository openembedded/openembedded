#!/bin/sh

# FIXME: Use /dev/input/touchscreen, once we have this logic on all hotplug system
# Yes, hardcoding the event node is wrong, will fix this eventually
TSLIB_TSDEVICE=/dev/input/event1

export TSLIB_TSDEVICE
