require bluez-utils.inc

DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://bluez.sourceforge.net/download/bluez-utils-${PV}.tar.gz \
           file://hcid.conf \
           file://02dtl1_cs.sh \
          "
 
PR = "r0"
