require kismet.inc

# patches *.diff are from openSUSE
SRC_URI += "file://kismet-2008-05-R1-crash.diff;patch=1;pnum=0 \
            file://kismet-2008-05-R1-fmt.diff;patch=1;pnum=0 \
            file://kismet-2008-05-R1-infinite-loop.diff;patch=1;pnum=0 \
            file://kismet-2008-05-R1-nonvoid.diff;patch=1;pnum=0 \
            file://fix_strip.patch;patch=1"

PR = "r0"

SRC_URI[md5sum] = "6ee365d36354b4dee4945e67f8149294"
SRC_URI[sha256sum] = "a298d44f8a6ec977021cd492a720987ded81b5c4baf5f68b36f1282a23c9f7d3"
