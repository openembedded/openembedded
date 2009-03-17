PR = "r0"

TOOLCHAIN_HOST_TASK = "task-slugos-toolchain-host"

# TBD: need to determine minimal library set to provide;
# uncomment next line and bump PR when this is done.
#TOOLCHAIN_TARGET_TASK = "task-slugos-toolchain-target"

require meta-toolchain.bb
SDK_SUFFIX = "toolchain-slugos"