/*
 *  linux/drivers/i2c/chips/tsc2003.c
 *
 *  Copyright (C) 2005 Bill Gatliff <bgat at billgatliff.com>
 *  Changes for 2.6.20 kernel by Nicholas Chen <nchen at cs.umd.edu>
 *  Changes to poll for events rather than use penirq by 
 *  Chris Dollar <chris.dollar at gmail.com>
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License version 2 as
 *  published by the Free Software Foundation.
 *
 *  Driver for TI's TSC2003 I2C Touch Screen Controller
 */

#include <linux/module.h>
#include <linux/init.h>
#include <linux/slab.h>
#include <linux/i2c.h>
#include <linux/string.h>
#include <linux/bcd.h>
#include <linux/list.h>
#include <linux/device.h>
#include <linux/input.h>
#include <linux/delay.h>

#define DRIVER_NAME "tsc2003"
#define TSC2003_CMD(cn,pdn,m) (((cn) << 4) | ((pdn) << 2) | ((m) << 1))
#define ADC_MAX ((1 << 12) - 1)

//#define CONFIG_I2C_DEBUG_CHIP 1

static unsigned short normal_i2c[] = { 0x48, I2C_CLIENT_END };

I2C_CLIENT_INSMOD_1(tsc2003);

enum tsc2003_pd {
	PD_POWERDOWN = 0,
	PD_IREFOFF_ADCON = 1,
	PD_IREFON_ADCOFF = 2,
	PD_IREFON_ADCON = 3,
	PD_PENIRQ_ARM = PD_IREFON_ADCOFF,
	PD_PENIRQ_DISARM = PD_IREFON_ADCON,
};

enum tsc2003_m {
	M_12BIT = 0,
	M_8BIT = 1
};

enum tsc2003_cmd {
	MEAS_TEMP0 = 0,
	MEAS_VBAT1 = 1,
	MEAS_IN1 = 2,
	MEAS_TEMP1 = 4,
	MEAS_VBAT2 = 5,
	MEAS_IN2 = 6,
	ACTIVATE_NX_DRIVERS = 8,
	ACTIVATE_NY_DRIVERS = 9,
	ACTIVATE_YNX_DRIVERS = 10,
	MEAS_XPOS = 12,
	MEAS_YPOS = 13,
	MEAS_Z1POS = 14,
	MEAS_Z2POS = 15
};

struct tsc2003_data {
	struct i2c_client client;
	struct device_driver driver;
	struct input_dev *idev;
	struct task_struct *tstask;
	struct completion tstask_completion;
	enum tsc2003_pd pd;
	enum tsc2003_m m;
	int vbat1;
	int vbat2;
	int temp0;
	int temp1;
	int in1;
	int in2;
};

static int tsc2003_i2c_detect(struct i2c_adapter *adapter, int address,
			      int kind);

static int tsc2003_read(struct tsc2003_data *data, enum tsc2003_cmd cmd,
			enum tsc2003_pd pd, int *val)
{
	char c;
	char d[2];
	int ret;

	c = TSC2003_CMD(cmd, pd, data->m);
	ret = i2c_master_send(&data->client, &c, 1);
	if (ret <= 0)
		goto err;

	udelay(20);
	ret =
	    i2c_master_recv(&data->client, d, data->m == M_12BIT ? 2 : 1);
	if (ret <= 0)
		goto err;

	if (val) {
		*val = d[0];
		*val <<= 4;
		if (data->m == M_12BIT)
			*val += (d[1] >> 4);
	}
#if defined(CONFIG_I2C_DEBUG_CHIP)
	printk(KERN_ERR "%s: val[%x] = %d\n",
	       __FUNCTION__, cmd, (((int) d[0]) << 8) + d[1]);
#endif

	return 0;
      err:if (!ret)
		ret = -ENODEV;
	return ret;
}

static inline int tsc2003_read_temp0(struct tsc2003_data *d, enum
				     tsc2003_pd pd, int *t)
{
	return tsc2003_read(d, MEAS_TEMP0, pd, t);
}

static inline int tsc2003_read_temp1(struct tsc2003_data *d, enum
				     tsc2003_pd pd, int *t)
{
	return tsc2003_read(d, MEAS_TEMP1, pd, t);
}

static inline int tsc2003_read_xpos(struct tsc2003_data *d, enum
				    tsc2003_pd pd, int *x)
{
	return tsc2003_read(d, MEAS_XPOS, pd, x);
}

static inline int tsc2003_read_ypos(struct tsc2003_data *d, enum
				    tsc2003_pd pd, int *y)
{
	return tsc2003_read(d, MEAS_YPOS, pd, y);
}

static inline int tsc2003_read_pressure(struct tsc2003_data *d, enum
					tsc2003_pd pd, int *p)
{
	return tsc2003_read(d, MEAS_Z1POS, pd, p);
}

static inline int tsc2003_read_in1(struct tsc2003_data *d, enum
				   tsc2003_pd pd, int *t)
{
	return tsc2003_read(d, MEAS_IN1, pd, t);
}

static inline int tsc2003_read_in2(struct tsc2003_data *d, enum
				   tsc2003_pd pd, int *t)
{
	return tsc2003_read(d, MEAS_IN2, pd, t);
}

static inline int tsc2003_read_vbat1(struct tsc2003_data *d, enum
				     tsc2003_pd pd, int *t)
{
	return tsc2003_read(d, MEAS_VBAT1, pd, t);
}

static inline int tsc2003_read_vbat2(struct tsc2003_data *d, enum
				     tsc2003_pd pd, int *t)
{
	return tsc2003_read(d, MEAS_VBAT2, pd, t);
}

static inline int tsc2003_powerdown(struct tsc2003_data *d)
{
	/* we don't have a distinct powerdown command,
	   so do a benign read with the PD bits cleared */
	return tsc2003_read(d, MEAS_IN1, PD_POWERDOWN, 0);
}

void tsc2003_init_client(struct i2c_client *client)
{
	struct tsc2003_data *data = i2c_get_clientdata(client);

	data->pd = PD_PENIRQ_DISARM;
	data->m = M_8BIT;
	return;
}

static int tsc2003ts_thread(void *v)
{
	struct tsc2003_data *d = v;
	struct task_struct *tsk = current;

	d->tstask = tsk;

	daemonize(DRIVER_NAME "tsd");
	allow_signal(SIGKILL);

	complete(&d->tstask_completion);

#if defined(CONFIG_I2C_DEBUG_CHIP)
	printk(KERN_INFO "%s: address 0x%x\n",
	       __FUNCTION__, d->client.addr);
#endif

	do {
		unsigned int x, y, p;
		int pen_is_up = 0;

		d->pd = PD_PENIRQ_DISARM;
		tsc2003_read_xpos(d, PD_PENIRQ_DISARM, &x);
		tsc2003_read_ypos(d, PD_PENIRQ_DISARM, &y);
		tsc2003_read_pressure(d, PD_PENIRQ_DISARM, &p);

		if (p < 64) {
			p = 0;
		}
#if defined(CONFIG_I2C_DEBUG_CHIP)
		printk(KERN_INFO "TSD X: %d Y: %d P: %d\n", x, y, p);
#endif

		if (!pen_is_up) {
			input_report_abs(d->idev, ABS_X, 4096 - x);
			input_report_abs(d->idev, ABS_Y, 4096 - y);
			input_report_abs(d->idev, ABS_PRESSURE, p);
			input_sync(d->idev);
		}

		if (p == 0) {
#if defined(CONFIG_I2C_DEBUG_CHIP)
			printk(KERN_INFO "No pressure - pen is up!\n");
#endif
			pen_is_up = 1;
		} else {
#if defined(CONFIG_I2C_DEBUG_CHIP)
			printk(KERN_INFO
			       "Pen is still down - sleeping and will re-sample!\n");
#endif
			pen_is_up = 0;
		}

		// sleep for 3 jiffies to give us about 30 updates/sec
		msleep(3);

	} while (!signal_pending(tsk));

	d->tstask = NULL;
	complete_and_exit(&d->tstask_completion, 0);
}

static int tsc2003_idev_open(struct input_dev *idev)
{
	struct tsc2003_data *d = idev->private;
	int ret = 0;

	if (d->tstask)
		panic(DRIVER_NAME "tsd already running (!). abort.");

	ret = kernel_thread(tsc2003ts_thread, d, CLONE_KERNEL);
	if (ret >= 0) {
		wait_for_completion(&d->tstask_completion);
		ret = 0;
	}

	return ret;
}

static void tsc2003_idev_close(struct input_dev *idev)
{
	struct tsc2003_data *d = idev->private;
	if (d->tstask) {
		send_sig(SIGKILL, d->tstask, 1);
		wait_for_completion(&d->tstask_completion);
	}

	return;
}

static int tsc2003_driver_register(struct tsc2003_data *data)
{
	struct input_dev *idev;
	int ret = 0;

	init_completion(&data->tstask_completion);

	idev = input_allocate_device();
	data->idev = idev;

	idev->private = data;
	idev->name = DRIVER_NAME;
	idev->evbit[0] = BIT(EV_ABS);
	idev->open = tsc2003_idev_open;
	idev->close = tsc2003_idev_close;
	idev->absbit[LONG(ABS_X)] = BIT(ABS_X);
	idev->absbit[LONG(ABS_Y)] = BIT(ABS_Y);
	idev->absbit[LONG(ABS_PRESSURE)] = BIT(ABS_PRESSURE);
	input_set_abs_params(idev, ABS_X, 0, ADC_MAX, 0, 0);
	input_set_abs_params(idev, ABS_Y, 0, ADC_MAX, 0, 0);
	input_set_abs_params(idev, ABS_PRESSURE, 0, 0, 0, 0);

	if (!ret) {
		input_register_device(idev);
		printk(KERN_INFO "tsc2003 - registering input device\n");
	}

	return ret;
}

static int tsc2003_i2c_attach_adapter(struct i2c_adapter *adapter)
{
	printk(KERN_INFO "tsc2003 i2c touch screen controller\n");
#if defined(CONFIG_I2C_DEBUG_CHIP)
	printk(KERN_INFO "Bill Gatliff <bgat at billgatliff.com\n");
	printk(KERN_INFO "Nicholas Chen <nchen at cs.umd.edu>\n");
#endif
	return i2c_probe(adapter, &addr_data, tsc2003_i2c_detect);
}

static int tsc2003_i2c_detach_client(struct i2c_client *client)
{
	int err;
	struct tsc2003_data *d = i2c_get_clientdata(client);

	input_unregister_device(d->idev);

	if ((err = i2c_detach_client(client))) {
		dev_err(&client->dev, "Client deregistration failed, "
			"client not detached.\n");
		return err;
	}

	return 0;
}

static struct i2c_driver tsc2003_driver = {
	.driver = {
		   .owner = THIS_MODULE,
		   .name = DRIVER_NAME,
		   },
	.attach_adapter = tsc2003_i2c_attach_adapter,
	.detach_client = tsc2003_i2c_detach_client,
};

static int tsc2003_i2c_detect(struct i2c_adapter *adapter, int address,
			      int kind)
{
	struct i2c_client *new_client;
	struct tsc2003_data *data;

	int err = 0;
	const char *name = "";

	if (!i2c_check_functionality(adapter, I2C_FUNC_SMBUS_BYTE_DATA
				     | I2C_FUNC_I2C |
				     I2C_FUNC_SMBUS_WORD_DATA))
		goto exit;

	data = kcalloc(1, sizeof(*data), GFP_KERNEL);
	if (!data) {
		err = -ENOMEM;
		goto exit;
	}

	new_client = &data->client;
	i2c_set_clientdata(new_client, data);
	new_client->addr = address;
	new_client->adapter = adapter;
	new_client->driver = &tsc2003_driver;
	new_client->flags = 0;

	/* TODO: I'm pretty sure I'm not dealing with kind correctly */
	if (kind == 0 /* identification */  || kind < 0 /* detection */ )
		kind = tsc2003;

	if (kind == tsc2003)
		name = DRIVER_NAME;

	/* try a command, see if we get an ack;
	   if we do, assume it's our device */
	printk(KERN_INFO "%s: probing address 0x%x\n",
	       __FUNCTION__, address);
	err = tsc2003_powerdown(data);
	if (err >= 0) {
		strlcpy(new_client->name, name, I2C_NAME_SIZE);
		err = i2c_attach_client(new_client);
		if (err)
			goto exit_free;

		tsc2003_init_client(new_client);

		err = tsc2003_driver_register(data);
		if (err < 0)
			goto exit_free;

		printk(KERN_INFO "%s: device address 0x%x attached.\n",
		       __FUNCTION__, address);
		return 0;
	}
	/* failure to detect when everything else is ok isn't an error */
	else
		err = 0;

      exit_free:kfree(new_client);
      exit:return err;
}

static int __init tsc2003_init(void)
{
	return i2c_add_driver(&tsc2003_driver);
}

static void __exit tsc2003_exit(void)
{
	i2c_del_driver(&tsc2003_driver);
}

MODULE_AUTHOR("Bill Gatliff <bgat at billgatliff.com>");
MODULE_DESCRIPTION("TSC2003 Touch Screen Controller driver");
MODULE_LICENSE("GPL");

module_init(tsc2003_init);
module_exit(tsc2003_exit);
