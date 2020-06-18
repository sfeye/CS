const express = require('express');
const router = express.Router();

router.get('/', (req, res, next) => {
    res.status(200).json({
        message: 'Orders were fetched'
    })
});

router.post('/', (req, res, next) => {
    const order = {
        productID: req.body.productID,
        quantity: req.body.quantity
    }
    res.status(201).json({
        message: 'Order was created',
        order: order
    })
});

router.get('/:orderID', (req, res, next) => {
    res.status(200).json({
        message: 'Order was fetched'
    });
});

router.delete('/:orderID', (req, res, next) => {
    res.status(200).json({
        message: 'Order was deleted'
    });
});

module.exports = router;