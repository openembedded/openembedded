/* 
 *  backsaver - Small backlight power saver daemon
 *
 *  This app relies on contemporary Linux 2.6 intefaces, like
 *  backlight class dev and generic input devices. Legacy interfaces
 *  are not supported by design.
 *
 *  Copyright (C) 2007, 2008 Paul Sokolovsky <pmiscml@gmail.com>
 *   
 *  This program is free software; you can redistribute it and/or 
 *  modify it under the terms of the GNU General Public License 
 *  as published by the Free Software Foundation; either version 
 *  2 of the License, or (at your option) any later version. 
 */

#include <getopt.h>
#include <unistd.h>
#include <fcntl.h>
#include <dirent.h>
#include <sys/stat.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int opt_verbose;
int opt_timeout = 2;
int opt_power;
int opt_brightness = -1;

char readbuf[256];
fd_set read_fds;
fd_set work_fds;
int fds[32];

int bl_state = 1;

#define BL_PATH "/sys/class/backlight/"

/* Backlight device properties */
char bldev_brightness_path[256] = BL_PATH;
char bldev_power_path[256] = BL_PATH;
int  bldev_max_brightness;
int  bldev_saved_brightness;
int  bldev_dim_brightness;

void fatal(char *msg) 
{
    fprintf(stderr, "%s\n", msg);
    exit(1);
}

int sysfs_get_value(char *fname)
{
    char buf[64];
    int fd = open(fname, O_RDONLY);
    int sz = read(fd, buf, sizeof(buf) - 1);
    buf[sz] = 0;
    close(fd);
    return atoi(buf);
}

void sysfs_set_value(char *fname, int val)
{
    char buf[64];
    int fd = open(fname, O_WRONLY);
    int sz = sprintf(buf, "%d\n", val);
    write(fd, buf, sz);
    close(fd);
}

char *bldev_scan()
{
    static char name[256];
    DIR *dir;
    struct dirent *de;
    int more_than_one = 0;
    
    dir = opendir(BL_PATH);
    if (!dir)
	fatal("Backlight device class does not seem to be support by kernel (" BL_PATH " is absent)");

    *name = 0;
    while (de = readdir(dir)) {
	if (de->d_name[0] == '.')
	    continue;
	if (*name == 0) {
	    strcpy(name, de->d_name);
	} else {
	    more_than_one = 1;
	    break;
	}
    }

    closedir(dir);
    if (*name == 0)
	fatal("There does not seem to be any backlight device available (" BL_PATH " is empty)");
    if (more_than_one)
	fatal("There seems to be several backlight devices available, use --device= option");

    return name;
}

void bldev_init(char *bldev)
{
    strcat(bldev_brightness_path, bldev);
    strcat(bldev_brightness_path, "/brightness");
    strcat(bldev_power_path, bldev);
    strcat(bldev_power_path, "/power");

    char buf[PATH_MAX];
    memcpy(buf, BL_PATH, sizeof(BL_PATH));
    strcat(buf, bldev);
    strcat(buf, "/max_brightness");
    bldev_max_brightness = sysfs_get_value(buf);
    
    bldev_dim_brightness = bldev_max_brightness * opt_brightness / 100;
}

void set_backlight(int state) 
{
    if (!bl_state) {
	if (opt_verbose)
	    printf("BL off\n");
	if (opt_power) {
	    sysfs_set_value(bldev_power_path, 4);
	} else {
	    bldev_saved_brightness = sysfs_get_value(bldev_brightness_path);
	    sysfs_set_value(bldev_brightness_path, bldev_dim_brightness);
	}
    } else {
	if (opt_verbose)
	    printf("BL on\n");
	if (opt_power) {
	    sysfs_set_value(bldev_power_path, 0);
	} else {
	    sysfs_set_value(bldev_brightness_path, bldev_saved_brightness);
	}
    }
}

#define INPUT_PATH "/dev/input/"

int main_loop(int argc, char *argv[], int argstart) 
{
    fd_set read_fds;
    struct timeval timeout;
    int i, maxfd = 0, numfd = 0;
    
    FD_ZERO(&read_fds);
    
    if (argstart == argc) {
	static char path[256] = INPUT_PATH;
        DIR *dir;
	struct dirent *de;
	struct stat stat;
    
	dir = opendir(INPUT_PATH);
	if (!dir)
	    fatal("Cannot open generic input device directory (" INPUT_PATH " is absent)");

	while (de = readdir(dir)) {
	    if (de->d_name[0] == '.')
		continue;
	    strcpy(path + sizeof(INPUT_PATH) - 1, de->d_name);
	    
	    if (lstat(path, &stat))
		fatal("Cannot stat input device to monitor");
	    if (S_ISLNK(stat.st_mode)) {
		if (opt_verbose)
		    printf("Skipping symlink %s\n", path);
		continue;
	    }
	    if (opt_verbose)
		printf("Using %s\n", path);

    	    int fd = open(path, O_RDONLY);
	    if (fd == -1)
		fatal("Cannot open input device to monitor");
	    if (fd > maxfd)
		maxfd = fd;
	    fds[numfd++] = fd;
	    FD_SET(fd, &read_fds);
	}

	closedir(dir);
    } else {
        for (i = argstart; i < argc; i++) {
	    if (opt_verbose)
		printf("Using: %s\n", argv[i]);
    	    int fd = open(argv[i], O_RDONLY);
	    if (fd == -1)
		fatal("Cannot open input device to monitor");
	    if (fd > maxfd)
		maxfd = fd;
	    fds[numfd++] = fd;
	    FD_SET(fd, &read_fds);
        }
    }

    timeout.tv_usec = 0;

    while (1) {
	memcpy(&work_fds, &read_fds, sizeof(read_fds));
	timeout.tv_sec = opt_timeout;
	i = select(maxfd + 1, &work_fds, NULL, NULL, &timeout);
	if (opt_verbose)
    	    printf("Select returned: %d\n", i);
	if (i > 0) {
	    if (!bl_state) {
		bl_state = 1;
		set_backlight(bl_state);
	    }
	    for (i = 0; i < numfd; i++) {
		if (FD_ISSET(fds[i], &work_fds)) {
		    int sz = read(fds[i], readbuf, sizeof(readbuf));
		    if (opt_verbose)
			printf("Discarded %d bytes from fd %d\n", sz, fds[i]);
		}
	    }
	} else {
	    if (bl_state) {
		bl_state = 0;
		set_backlight(bl_state);
	    }
	}
	    
    }
}

struct option options[] = {
    { "verbose", no_argument, &opt_verbose, 1 },
    { "timeout", required_argument, NULL, 't' },
    { "power", no_argument, &opt_power, 1 },
    { "brightness", required_argument, NULL, 'b' },
    NULL
}; 
int main(int argc, char *argv[])
{
    int opt;
    while ((opt = getopt_long(argc, argv, "?h", options, NULL)) != -1) {
	switch (opt) {
	case 't':
	    opt_timeout = atoi(optarg);
	    break;
	case 'b':
	    opt_brightness = atoi(optarg);
	    break;
	}
    }
    printf("%d\n", optind);
    
    char *bldev = bldev_scan();
    bldev_init(bldev);
    
    return main_loop(argc, argv, optind);
}
