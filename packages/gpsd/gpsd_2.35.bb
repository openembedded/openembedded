require gpsd.inc

SRC_URI = "http://download.berlios.de/gpsd/gpsd-${PV}.tar.gz \
           file://gpsd-default \
           file://gpsd \
           file://gpsd_dbus.patch;patch=1 "

PR = "r0"
