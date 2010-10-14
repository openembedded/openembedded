# This is a straw-man recipe for step 1 in the two-step build of
# mono. Because it's impossible to build the mcs directory
# in cross-compile mode, this recipe will do a native build,
# then tar the resulting install tree for usage by the mono
# package in step 2.
# See http://www.mono-project.com/Mono:ARM

require mono.inc
require mono-mcs-intermediate.inc

PR = "${INC_PR}.0"

SRC_URI[md5sum] = "b1dc21bac2c7c75814a9f32246eadadd"
SRC_URI[sha256sum] = "0ecb82d2007f472f8eebc85c349813515bf642e6ea021890ece40555ad50d947"

