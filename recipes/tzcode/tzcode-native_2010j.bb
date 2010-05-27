require tzcode-native.inc

# Note that elsie.nci.nih.gov removes old versions when new is coming out
# So if this doesn't build for you because of missing source file, just
# bump it to the latest available version, removing old one
# Also, tzdata (and it is needed to build tzcode) version can differ from
# tzcode version, thus this variable

TZDATA_PV = "2010j"

SRC_URI[tzcode-2010j.md5sum] = "5ba8345720296d3a659b349b2052d139"
SRC_URI[tzcode-2010j.sha256sum] = "f32b46405190e3a5f1ee4db9fb50aaf1379e6af4e5493402ebfc8ee757058e97"
SRC_URI[tzdata-2010j.md5sum] = "f668f66b260e14b477eac3f48bcfb5f4"
SRC_URI[tzdata-2010j.sha256sum] = "dcf2101d0c5bb20a7f182866ea3e52b54c8f4d129c025a96c9a31377676f554b"

PR = "${INC_PR}.0"
