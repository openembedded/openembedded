require ti-codec-engine.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_omapl138 = "1"
DEFAULT_PREFERENCE_dm355 = "1"
DEFAULT_PREFERENCE_dm365 = "1"
DEFAULT_PREFERENCE_dm6467 = "1"

# tconf from xdctools dislikes '.' in pwd :/
PV = "2_25_01_06"

# Full-CE
#SRC_URI[cetarball.md5sum] = "729ede0fd24210d3c5439511fa859d51"
#SRC_URI[cetarball.sha256sum] = "81f815159f3dfda0525be6da543644b02c3610bcb080df170cbd27e2d8420ba2"

# Lite-CE
SRC_URI[cetarball.md5sum] = "5874d84766beb2042afe0cdd3823fe9e"
SRC_URI[cetarball.sha256sum] = "f155c27e4082f3dd79cf49511559e914d3792b82fd16caefc1739456ebec86ff"

