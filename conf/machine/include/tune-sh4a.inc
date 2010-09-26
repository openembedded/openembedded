# NOTE: This file provides the option for m4a(sh4a).
# It is not compatible in m4a and m4(sh4). 
# The binary optimized by m4a doesn't operate on sh4. It works on sh4a only.
# If you want to use binary that  work on sh4 and sh4a, you should use 
# "conf/machine/include/tune-sh4.inc".

TARGET_CC_ARCH = "-ml -m4a"
FEED_ARCH = "sh4"
BASE_PACKAGE_ARCH = "sh4"
