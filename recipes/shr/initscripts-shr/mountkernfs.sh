#!/bin/sh

supported_kernel() {
  case "$(uname -r)" in
    2.[012345].*|2.6.[0-9]|2.6.[0-9][!0-9]*) return 1 ;;
    2.6.1[0-7]|2.6.1[0-7][!0-9]*) return 1 ;;
  esac
  return 0
}

check_kernel() {
	if ! supported_kernel; then
		echo "WARNING: kernel < 2.6.18"
	fi

	if ! grep -qs devpts /proc/filesystems; then
		echo "WARNING: kernel does not support devpts"
	fi

	if ! grep -qs tmpfs /proc/filesystems; then
		echo "WARNING: kernel does not support tmpfs"
	fi
}

if [ -d /proc ]; then
	mount -n -t proc proc /proc
fi

check_kernel

if [ -d /sys ]; then
	mount -n -t sysfs sysfs /sys
fi
