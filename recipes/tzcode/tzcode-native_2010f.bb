require tzcode-native.inc

# Note that elsie.nci.nih.gov removes old versions when new is coming out
# So if this doesn't build for you because of missing source file, just
# bump it to the latest available version, removing old one
# Also, tzdata (and it is needed to build tzcode) version can differ from
# tzcode version, thus this variable

TZDATA_PV = "2010i"

SRC_URI[tzcode-2010f.md5sum] = "e530cc9bbdfd5e8c1eac21a68f4d5656"
SRC_URI[tzcode-2010f.sha256sum] = "651d866c91ada925b4ac9491e69ebd5c355c46b2c01dd1741b5e6a609d93eb1e"
SRC_URI[tzdata-2010i.md5sum] = "4d2a90afd5bffe8df97f3def245e178e"
SRC_URI[tzdata-2010i.sha256sum] = "bee0a26cca54db3413416d968c0a6361d83188b112d2512559d0e3602f254dc3"

PR = "${INC_PR}.2"
