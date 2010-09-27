require tzcode-native.inc

# Note that elsie.nci.nih.gov removes old versions when new is coming out
# So if this doesn't build for you because of missing source file, just
# bump it to the latest available version, removing old one
# Also, tzdata (and it is needed to build tzcode) version can differ from
# tzcode version, thus this variable

TZDATA_PV = "2010m"

SRC_URI[tzcode-2010m.md5sum] = "dee44c5b5ff70c424f62333b4c6d09a2"
SRC_URI[tzcode-2010m.sha256sum] = "24f0274d531a53415f1314891bc0df47778044a53186a1c0eb2df3991af91a18"
SRC_URI[tzdata-2010m.md5sum] = "9e33cb126c8cb6673f39390d347fb0e2"
SRC_URI[tzdata-2010m.sha256sum] = "1454a13a32e23e81195404d00ab97a64a356e9a5852fc7d121ed7e58cbdb75aa"

PR = "${INC_PR}.0"
