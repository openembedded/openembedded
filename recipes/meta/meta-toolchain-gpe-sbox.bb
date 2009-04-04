PR = "r2"
TOOLCHAIN_TARGET_TASK = "\
    task-sdk-base \
    task-sdk-sbox \
    task-sdk-sbox-gpe \
    task-sdk-x11 \
    task-sdk-x11-ext \
    task-sdk-gpe"

require meta-toolchain.bb

SDK_SUFFIX = "toolchain-gpe-sbox"
