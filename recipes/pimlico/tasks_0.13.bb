require tasks.inc

SRC_URI = "http://pimlico-project.org/sources/${PN}/${PN}-${PV}.tar.gz \
        file://tasks-owl.diff;patch=1;pnum=0 file://libtool.diff;patch=1;pnum=0"

SRC_URI[md5sum] = "536ffbbd0f38489c8e3ea9eaf0f67d59"
SRC_URI[sha256sum] = "3a1029eb587a0587cf3ebcb8c256062ca595b4f5d0a30188fa4aae3adb49ca5a"
