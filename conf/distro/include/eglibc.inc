# Add glibc overrides to the overrides for eglibc.
OVERRIDES =. "libc-glibc:"

# The things eglibc can provide.  We default to wanting eglibc to provide them.
PREFERRED_PROVIDER_virtual/libiconv ?= "eglibc"
PREFERRED_PROVIDER_virtual/libintl ?= "eglibc"
PREFERRED_PROVIDER_virtual/libc = "eglibc"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}libc-initial = "eglibc-initial"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}libc-for-gcc = "eglibc"

# eglibc is configured for OLDEST_KERNEL kernel version, so we set minimal
# sane versions there

OLDEST_KERNEL ?= "2.4.0"

# ARM OABI is fine with 2.4.0, EABI is not, so we override on "-gnueabi"
# TARGET_OS here, not on architecture which is 'arm' in both cases
OLDEST_KERNEL_linux-gnueabi ?= "2.6.16"
OLDEST_KERNEL_sparc64 ?= "2.4.21"
OLDEST_KERNEL_ppc64 ?= "2.4.21"
DISTRO_FEATURES_EGLIBC ?= "ipv6 backtrace big-macros bsd cxx-tests catgets \
                           charsets crypt crypt-ufc db-aliases envz fcvt fmtmsg \
                           fstab ftraverse getlogin idn inet inet-anl libm \
                           libm-big locales locale-code memusage nis nsswitch \
                           rcmd rtld-debug spawn streams sunrpc utmp utmpx \
                           wordexp posix-clang-wchar posix-regexp \
                           posix-regexp-glibc posix-wchar-io"

