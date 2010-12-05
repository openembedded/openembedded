require ti-dsplink.inc

PE = "1"
PV = "1_65_00_03"
PV_dot = "1.65.00.03"
PV_major = "1_65"

PV_DL_PATH = "DSPLink/${PV_major}/${PV}/${PV_dot}"

SRC_URI += "file://dsplink-BKL-fix.patch"

SRC_URI[dsplinktarball.md5sum] = "1bda596b631bd2f517edc70f6be4f2ca"
SRC_URI[dsplinktarball.sha256sum] = "4b1bda89bd8465b887f5bcdf7b95018bc1d1f8968c0c44f8cbad2a9e1c52bcb7"

