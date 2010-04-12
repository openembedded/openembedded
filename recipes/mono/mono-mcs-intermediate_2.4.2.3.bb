# This is a straw-man recipe for step 1 in the two-step build of
# mono. Because it's impossible to build the mcs directory
# in cross-compile mode, this recipe will do a native build,
# then tar the resulting install tree for usage by the mono
# package in step 2.
# See http://www.mono-project.com/Mono:ARM

require mono-${PV}.inc
require mono-mcs-intermediate.inc

SRC_URI += ""

PR = "${INC_PR}.1"

SRC_URI[md5sum] = "696f25afc8453cd0d1c78de6e905dcf2"
SRC_URI[sha256sum] = "1bab0d4e2906c88736ff5e242f2905f4c3535ccfc05bb5c427b72adf0e9236ae"
