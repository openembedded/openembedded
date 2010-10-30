#include <linux/input.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
#include <unistd.h>

#define FNKEY 29 /* key code */

int main(int argc, char **argv)
{
	int fd;
	int mode = 0; /* 0 unpressed ; 2 pressed */

	if(argc < 2) {
		printf("usage: %s <device>\n", argv[0]);
		return 1;
	}

	fd = open(argv[1], O_RDONLY);
	struct input_event ev;

	while (1) {
		read(fd, &ev, sizeof(struct input_event));

		if ((ev.type == 1) && (ev.code == FNKEY)) {
			if (((ev.value == 2) || (ev.value == 1)) && (mode == 0)) { /* PRESSED */
				system("xdotool keydown Mode_switch; xdotool keydown SHIFT");
				/* printf("system press\n"); */
				mode = 2;
			} else if ((ev.value == 0) && (mode == 2)) { /* KEY UP */
				system("xdotool keyup Mode_switch; xdotool keyup SHIFT");
				/* printf("system unpress\n"); */
				mode = 0;
			}
			/* printf("key %i state %i\n", ev.code, ev.value); */

		}
	}
}

