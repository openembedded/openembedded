COMPATIBLE_HOST = "arm.*-linux"

# For these old 2.4 kernels we override in sharprom-compatible.conf
#COMPATIBLE_MACHINE = "(poodle|poodle255)"
COMPATIBLE_MACHINE = "none"

DEPENDS = "poodle-kernel-2.4-embedix poodle255-kernel-2.4-embedix"
