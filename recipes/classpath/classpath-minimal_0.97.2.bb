require classpath.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/${PBN}-${PV}"

SRC_URI += "\
  file://netif_16.patch;patch=1;pnum=0 \
  file://SimpleName.diff;patch=1;pnum=0 \
  file://javanet-local.patch;patch=1;pnum=0 \
  file://ecj_java_dir.patch;patch=1 \
  file://autotools.patch;patch=1 \
  file://decimalformat.patch;patch=1 \
  file://cp-byte-loophelper.patch;patch=1;pnum=0 \
  "

PR = "r3"

PROVIDES = "${PN} classpath"

EXTRA_OECONF += "\
                --enable-local-sockets \
                --disable-alsa \
                --disable-gconf-peer \
                --disable-gtk-peer \
                --disable-plugin \
                --disable-dssi \
                --disable-examples \
               "

CPPACKAGES = "${PBN}-common ${PBN}-tools"


SRC_URI[md5sum] = "6a35347901ace03c31cc49751b338f31"
SRC_URI[sha256sum] = "001fee5ad3ddd043783d59593153510f09064b0d9b5aea82f535266f62f02db4"
