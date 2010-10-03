# eglibc needs this flag to default to 64bit otherwise it chooses N32 ABI
TARGET_CC_ARCH = "-mabi=64"
