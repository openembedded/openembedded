require e2fsprogs.inc

PR = "${INC_PR}"

SRC_URI += "file://mkinstalldirs.patch;patch=1"

SRC_URI[md5sum] = "e218df6c84fc17c1126d31de9472a76c"
SRC_URI[sha256sum] = "b3d7d0e1058a3740ddae83d47285bd9dce161eec9e299dde7996ed721da32198"
