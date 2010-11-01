require xorg-app-common.inc
DESCRIPTION = "a sample implementation of a screen saver for X"
DEPENDS += " libxscrnsaver libxt libxaw libxt"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "e248acedcc95d44bdd140bdb861fdcee"
SRC_URI[archive.sha256sum] = "38f1d5380704234a37306ee13ea53be6eed4a1c6eb2c8ebdacca181465da56bb"
