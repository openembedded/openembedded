require ti-codec-engine.inc

PV = "2_25_01_06"

SRC_URI[cetarball.md5sum] = "5874d84766beb2042afe0cdd3823fe9e"
SRC_URI[cetarball.sha256sum] = "f155c27e4082f3dd79cf49511559e914d3792b82fd16caefc1739456ebec86ff"

SRC_URI_append_dm365 += "file://loadmodules.sh"
