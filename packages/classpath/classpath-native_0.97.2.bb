require classpath-native.inc

PR = "r2"

# The code affected by the javanet-local patch
# is usually not compiled. However if someone changes
# to --enable-local-sockets it will.
SRC_URI += "\
  file://netif_16.patch;patch=1;pnum=0 \
  file://SimpleName.diff;patch=1;pnum=0 \
  file://javanet-local.patch;patch=1;pnum=0 \
  file://sun-security-getproperty_0.96.1.patch;patch=1;pnum=0 \
  file://ecj_java_dir.patch;patch=1 \
  file://autotools.patch;patch=1 \
  file://decimalformat.patch;patch=1 \
  "

