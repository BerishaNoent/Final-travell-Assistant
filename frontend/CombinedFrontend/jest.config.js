module.exports = {
    // ...your other config here
    testEnvironment: 'jsdom',
    moduleNameMapper: {
      '\\.(css|less)$': '<rootDir>/__mocks__/styleMock.js',
    },
  };