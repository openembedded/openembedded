LICENSE = "GPL"
SECTION = "unknown"
DESCRIPTION = "Regex-markup performs regular expression-based text \
markup according to used-defined rules."


SRC_URI = "http://savannah.nongnu.org/download/regex-markup/regex-markup-${PV}.tar.gz"

inherit autotools

SRC_URI[md5sum] = "47f9df1cd3865d20aecd6d73e7a7518d"
SRC_URI[sha256sum] = "879f0af7622c1eb2d1b7c5f7d0ec53ea96fd48b05bc4f4c17542a2ea17fafba5"
