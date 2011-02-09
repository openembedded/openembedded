require tzcode-native.inc

# Note that elsie.nci.nih.gov removes old versions when new is coming out
# So if this doesn't build for you because of missing source file, just
# bump it to the latest available version, removing old one
# Also, tzdata (and it is needed to build tzcode) version can differ from
# tzcode version, thus this variable

TZDATA_PV = "2011b"

PR = "${INC_PR}.0"

SRC_URI[tzcode-2011b.md5sum] = "c63a1425f7252aef1fe54a258cdccff8"
SRC_URI[tzcode-2011b.sha256sum] = "8031d05102e5c5109521a282aaab0629680bec82db783c716905802313678d67"
SRC_URI[tzdata-2011b.md5sum] = "9eaf3ca354c42a32bd28e623539bf0e0"
SRC_URI[tzdata-2011b.sha256sum] = "ff45f5ddc2ec925249626d00d7bc2ffff587e0956a1d8245517a023bf27e4cc9"
