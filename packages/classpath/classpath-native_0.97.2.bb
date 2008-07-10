require classpath-native.inc

PR = "r0"

# The code affected by the javanet-local patch
# is usually not compiled. However if someone changes
# to --enable-local-sockets it will.
SRC_URI += "\
  file://netif_16.patch;patch=1;pnum=0 \
  file://SimpleName.diff;patch=1;pnum=0 \
  file://javanet-local.patch;patch=1;pnum=0 \
  "

