require ti-c6accel.inc


SRC_URI_append = "file://fix-loadmodule.patch"

PV = "1_01_00_01"

SRC_URI[c6accelbin.md5sum] = "b8d3b31bc14908e1946fecfd4596a8f1"
SRC_URI[c6accelbin.sha256sum] = "5239dfd7a5a240ec66f4788ebca455dc7a961d83a4e08fe61c6af0eb79594f7c"

