require classpath-native.inc

PR = "r4"

SRC_URI += "\
  file://gjar-prefix-patch.diff;patch=1;pnum=0 \
  file://xmlstream-fix.patch;patch=1;pnum=0 \
  file://getopt-filelist.patch;patch=1;pnum=0 \
  file://sun-security-getproperty_0.96.1.patch;patch=1;pnum=0 \
  "

