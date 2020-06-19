### Motivation
This demo makes use of our libraries to demonstrate how we can leverage the Safe transaction service to propose transaction to a safe.

### Setup project root files and environmental variables
* Create file called `.env.private_key` in the root of the project containing your private key in hex.
* Look at the `.env.private_key_FIELDS` for the values. **ORDER MATTERS**. 

### The libraries that were used for this project:
At the time of the writing of this documentation the dependencies are only available for android through jitpack. However, as shown in this documentation, it is possible to take the code over and run in a purely kotlin application. 
* [svalinn-kotlin](https://github.com/gnosis/svalinn-kotlin) (crypto, utils, models and rpc submodules)
* [bivrost-kotlin](https://github.com/gnosis/bivrost-kotlin)
* [Safe app (rinkeby)](https://gnosis-safe.io/app)
* [Safe transaction service (rinkeby)](https://safe-transaction.rinkeby.gnosis.io/)

For the sake of reusability of our Android code, [retrofit](https://github.com/square/retrofit) for our HTTP requests, [moshi](https://github.com/square/moshi/) for JSON serialization and deserialization. 

### Safe Transaction service and ABI method calls

We generated the bindings in kotlin using [bivrost-kotlin](https://github.com/gnosis/bivrost-kotlin) and we called the methods `Nonce` and `GetTransactionHash` for the purpose of this demo. From the [Safe transaction service](https://safe-transaction.rinkeby.gnosis.io/) we used the `/safes/{address}/transactions/` endpoint for proposing the transaction.

### Build and Run on the command line
`./gradlew run`
