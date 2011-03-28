require tzdata.inc

# Note that elsie.nci.nih.gov removes old archives after a new one is
# released. So if this doesn't build for you because of missing source file
# just bump it to the latest available version, removing the old one

PR = "${INC_PR}.0"

SRC_URI[md5sum] = "03c5793502b7c41985edd73146bf7e36"
SRC_URI[sha256sum] = "415a54774094e8dcdc9ba141fafbee4b3b2f2140a5b8cf012eea4b37fb9a23bd"
