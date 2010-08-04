require classpath.inc

SRC_URI += "\
  file://netif_16.patch;striplevel=0 \
  file://SimpleName.diff;striplevel=0 \
  file://javanet-local.patch;striplevel=0 \
  file://ecj_java_dir.patch \
  file://autotools.patch \
  file://decimalformat.patch \
  file://cp-byte-loophelper.patch;striplevel=0 \
  file://drawpolyline.patch;striplevel=0 \
  file://gtk-fix.patch;striplevel=0 \
  file://toolwrapper-exithook.patch \
  "

PR = "r11"

SRC_URI[md5sum] = "6a35347901ace03c31cc49751b338f31"
SRC_URI[sha256sum] = "001fee5ad3ddd043783d59593153510f09064b0d9b5aea82f535266f62f02db4"
