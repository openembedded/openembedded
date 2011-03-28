require tzcode-native.inc

# Note that elsie.nci.nih.gov removes old versions when new is coming out
# So if this doesn't build for you because of missing source file, just
# bump it to the latest available version, removing old one
# Also, tzdata (and it is needed to build tzcode) version can differ from
# tzcode version, thus this variable

TZDATA_PV = "2011d"

PR = "${INC_PR}.0"

SRC_URI[tzcode-2011d.md5sum] = "95095242ee368e6a7e107f154590ac11"
SRC_URI[tzcode-2011d.sha256sum] = "68f2c07471c5390199c09fe9fee6a22f8a4dac24713af88b92da17b33ad98cc7"
SRC_URI[tzdata-2011d.md5sum] = "03c5793502b7c41985edd73146bf7e36"
SRC_URI[tzdata-2011d.sha256sum] = "415a54774094e8dcdc9ba141fafbee4b3b2f2140a5b8cf012eea4b37fb9a23bd"
