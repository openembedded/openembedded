require postgresql.inc

PR = "r4"
DEFAULT_PREFERENCE = "-1"

SRC_URI += "file://no-ecpg-test.patch;patch=1"

SRC_URI[md5sum] = "af7ec100a33c41bfb8d87b5e0ec2f44a"
SRC_URI[sha256sum] = "8ff6afab743e894c0d96e668dcf9b3d3c1044719d6def45ef7390c64b54ed268"
