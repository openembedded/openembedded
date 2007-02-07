require mono.inc
DEPENDS = "mono-native glib-2.0"

#We only have a cpu-${arch}.h from arm, so let's mask out non-working architectures
COMPATIBLE_HOST = "arm.*-linux"
